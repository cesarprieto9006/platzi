package com.example.projectlist.screens.main.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.projectlist.screens.BaseViewModel
import com.example.projectlist.screens.main.model.DataFish
import com.example.projectlist.screens.main.repository.MainRepository
import com.example.projectlist.utils.SuperAppConstants
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: MainRepository) :
    BaseViewModel() {

    private val _dataData: MutableLiveData<ArrayList<DataFish>> = MutableLiveData()
    val dataData: LiveData<ArrayList<DataFish>> get() = _dataData

    var dataFish: DataFish = DataFish()

    var isError = MutableLiveData(false)

    var isImage = MutableLiveData(false)

    var isLoading = MutableLiveData(false)

    fun getData() {
        isLoading.value = true
        repository.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                isLoading.value = false
                _dataData.value=result
            }
            ) { error ->
                Timber.tag(SuperAppConstants.TAG_ERROR).e(error)
                isLoading.value = false
            }
    }

}