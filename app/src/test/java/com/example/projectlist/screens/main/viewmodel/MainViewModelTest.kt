package com.example.projectlist.screens.main.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.projectlist.LiveDataTestUtil
import com.example.projectlist.network.ApiService
import com.example.projectlist.screens.main.model.ResponseMeaning
import com.example.projectlist.screens.main.repository.MainRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito


class MainViewModelTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var apiService: ApiService
    private lateinit var mainRepository: MainRepository
    private lateinit var viewModel: MainViewModel



    @Before
    fun setUp() {
        apiService =  Mockito.mock(ApiService::class.java)
        mainRepository = MainRepository(apiService)
        viewModel = MainViewModel(mainRepository)

    }

    @Test
    fun `Validate if loading is activate`() {
        viewModel.isLoading.value=true
        assertEquals(true, LiveDataTestUtil.getValue(viewModel.isLoading))
        viewModel.isLoading.value=false
        assertEquals(false, LiveDataTestUtil.getValue(viewModel.isLoading))
    }

    @Test
    fun `Validate if the list has data to display it`() {
        viewModel.stateError.value=true
        assertEquals(true, LiveDataTestUtil.getValue(viewModel.stateError))
        viewModel.stateError.value=false
        assertEquals(false, LiveDataTestUtil.getValue(viewModel.stateError))
    }

    @Test
    fun `search acronym response is null`() {
        val responseMeaning = null
        val value =""

        Mockito.`when`(
            mainRepository.search(
                value
            )
        ).then {invocation ->
            invocation.getArgument<(ResponseMeaning) -> Unit>(0).invoke(ResponseMeaning())
        }

        assertEquals(responseMeaning, LiveDataTestUtil.getValue(viewModel.arrayMeaningResponse))
    }

}