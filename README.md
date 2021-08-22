# ScoreBoard

# Task Related
In this task, Results of teams are shown in Recyclerview<br/>
Data of results is recived from 2 APIS, these API's are called by using Coroutines. Both API's are called in parallel<br/>
Once data is recived from API's then data is stored into Database by using ROOM.<br/>
In case of any exception such as No internet connect. data will be fetched from database and than passed to view.<br/>


# Models Related
In this project there are 3 objects<br/>
1, DTO -> These are used when data source is API<br/>
2, DBModel -> These are used when data source is Databse<br/>
3, UIModel -> This is final UI Model with is passed to viewModel. Data from any source is converted into UIModel by using Mapper.<br/>




# Architecture Related
The app for built on Android Studio using Gradle build system<br/>
Kotlin programming language was used for the development<br/>
The MVVM architecture desgin patter was used for the development<br/>
Android's Architecture Components components were used to to acheive MVVM e.g LiveData, AndroidViewModel<br/>
Kotlins Coroutines were used asynchronous programming. <br/>

Hilt is for Injecting Repositories into viewModel<br/>
Retrofit was used for Networking along with OkHttp<br/>

# Motive
The purpose of this example is to share knowledge about (HILT)<br/>

