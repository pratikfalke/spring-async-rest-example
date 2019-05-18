package com.example.reactive.rest

import com.example.reactive.dataprovider.DataProvider
import com.example.reactive.model.Car
import io.reactivex.Observable
import io.swagger.annotations.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@Api
class RestEndpoint {

    @Autowired
    lateinit var dataProvider: DataProvider

    @GetMapping(path = ["cars"], produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    @ResponseBody
    @ApiResponses(value = [ApiResponse(code = 200, message = "Cars")])
    @ApiParam("nothing")
    fun getCars(): Observable<Car> {
        return dataProvider.getDataStream()
    }

}
