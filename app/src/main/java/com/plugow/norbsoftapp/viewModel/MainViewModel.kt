package com.plugow.norbsoftapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.plugow.norbsoftapp.data.local.NSItem
import com.plugow.norbsoftapp.data.local.YTItem
import com.plugow.norbsoftapp.data.remote.ApiService
import com.plugow.norbsoftapp.util.Event
import com.plugow.norbsoftapp.util.MainEvent
import com.plugow.norbsoftapp.util.RefreshableList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val service: ApiService): ViewModel(), RefreshableList<NSItem> {
    override val items: MutableLiveData<List<NSItem>> = MutableLiveData()
    override val isLoadingRefresh: MutableLiveData<Boolean> = MutableLiveData(false)
    private val disposables= CompositeDisposable()
    private val mEvent:MutableLiveData<Event<MainEvent>> = MutableLiveData()
    val event : LiveData<Event<MainEvent>>
        get() = mEvent


    override fun loadItems() {
        service.getYTSearchList()
            .map { mapAndSort(it.items) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    items.value = it
                    isLoadingRefresh.value = false
                },
                onError = {
                    isLoadingRefresh.value = false
                    mEvent.value = Event(MainEvent.ERROR)
                }
            )
    }

    private fun mapAndSort(items:List<YTItem>):List<NSItem>{
        return items
            .map { NSItem(it.snippet.title, it.snippet.description, it.snippet.thumbnails.medium.url) }
            .sortedBy { it.description.length }
    }


    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }


}