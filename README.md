<br/>
<p align="center">
  <a href="https://github.com/swapnil-musale/jetjoke">
    <img src="https://github.com/swapnil-musale/JetJoke/assets/15209914/bb626d76-701c-4618-a724-6562e621d71a" alt="Logo" width="120" height="120">
  </a>

  <h2 align="center">JetJoke - Joke Generator App</h2>

</p>
<p align="center">
<a href="https://github.com/swapnil-musale/JetJoke/actions"><img alt="Android CI Pipeline" src="https://github.com/swapnil-musale/JetJoke/actions/workflows/android_ci.yml/badge.svg?event=pull_request"/></a>
<a href="https://github.com/swapnil-musale/JetJoke/stargazers"><img alt="Github Repository starred" src="https://img.shields.io/github/stars/swapnil-musale/jetjoke"/></a>
<a href="https://www.codefactor.io/repository/github/swapnil-musale/jetjoke"><img alt="CodeFactor" src="https://www.codefactor.io/repository/github/swapnil-musale/jetjoke/badge"/></a>
<a href="https://codebeat.co/projects/github-com-swapnil-musale-jetjoke-master"><img alt="Codebeat Badge" src="https://codebeat.co/badges/c8e985e0-5377-4c2c-9705-abf273eef427"/></a>
<a href="https://opensource.org/licenses/Apache-2.0"><img alt="Apache License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
</p>

## ℹ️ Project Info : 
**JetJoke App** is build to demonstrate the use of Clean Architecture + MVVM in Android App Development. App is mainly divided into 3 layers i.e ```data```, ```domain``` & ```app``` (presentation).
It also showcase the implemetation of some of the Modern Jetpack Architecture Component.

## ⬇️ Download App :
<a href="https://play.google.com/store/apps/details?id=com.devx.jetjoke"><img alt="Get it on Google Play" src="https://play.google.com/intl/en_us/badges/images/generic/en-play-badge.png" height=80px />

## 👨‍💻 App Demo :
### Screenshot
<img src = "https://github.com/swapnil-musale/JetJoke/assets/15209914/53bac1df-21bc-4db8-bf42-74f55cf9ebf6.png" width=250/>

### Video
[Video Demo](https://github.com/swapnil-musale/JetJoke/assets/15209914/15d49fc6-666f-4acd-9b16-b590fe0df464)

## 📚 Libraries Used :
* [Kotlin][0] : Kotlin is statically typed & first-class language for Android Development.
* [Coroutines][1] : For Asynchronus or non-blocking operations.
* [Flows][2] : Data Streaming API which is built on top of Coroutines.
* [Jetpack Compose][3] : Toolkit for building native UI in a declarative way.
* [Splash Screen API][4] : Launch app with animation of launcher icon.
* [Retrofit][5] : Type-safe REST client for Android to consume RESTful web services.
* [Dagger Hilt][6] : Dependency injection library for Android.

[0]:  https://kotlinlang.org/
[1]:  https://kotlinlang.org/docs/coroutines-overview.html
[2]:  https://developer.android.com/kotlin/flow
[3]:  https://developer.android.com/jetpack/compose
[4]:  https://developer.android.com/develop/ui/views/launch/splash-screen
[5]:  https://github.com/square/retrofit
[6]:  https://dagger.dev/hilt/

## 🧰 Other Tools :
* [Kotlin DSL][7] : For writing gradle script for Kotlin is more readable and offers better compile-time.
* [Version Catalog][8] : Declaring gradle dependencies & plugins in central place.
* [Github Actions(CI/CD)][9] : Automate the build, test, and deployment pipeline through Github Actions.
* [Renovate][10] : To keep the app dependencies up-tp-date automatically.

[7]:  https://docs.gradle.org/current/userguide/kotlin_dsl.html
[8]:  https://docs.gradle.org/current/userguide/platforms.html
[9]:  https://github.com/features/actions
[10]: https://docs.renovatebot.com/

## 🏗️ App Architecture :
App is build using Clean Architecture design pattern. Which consist of three module as follows :
* [**app**](https://github.com/swapnil-musale/JetJoke/tree/master/app) - This module is responsible for handling user interaction, displaying data and managing user interface. Usually this module is decoupled from bossiness logic and communicate with domain module for accessing any data.
* [**domain**](https://github.com/swapnil-musale/JetJoke/tree/master/domain) - In this module contains core bussiness logic and it doesn't contains any platform related api usage and should only use java/kotlin language apis.
* [**data**](https://github.com/swapnil-musale/JetJoke/tree/master/data) - This module is mainly responsible for accessing data from remote or local source which is being called from domain module only.

![Clean-Architecture-in-Android](https://github.com/swapnil-musale/JetJoke/assets/15209914/526ea05d-d3d1-49da-b034-74628871a774)

## 🧪 Testing (ToDo):
* Unit & UI tests are under ToDo list and will be done soon - please watch out this space after some time for more info this section.

## 🌿 Branches :
* [**master**](https://github.com/swapnil-musale/JetJoke) - master branch will contain the production code which is deployed by [CD Pipeline](https://github.com/swapnil-musale/JetJoke/actions/workflows/android_cd.yml).
* [**development**](https://github.com/swapnil-musale/JetJoke/tree/development) - development branch will contain the on-going app feature developement or bug fix code which is targeted for upcoming release validated by [CI Pipeline](https://github.com/swapnil-musale/JetJoke/actions/workflows/android_ci.yml).

## 🚧 ToDo's :
- [ ] Display Joke by selected Category
- [ ] Search Joke functionality
- [ ] Unit Testing
- [ ] UI Testing
- [ ] Offline Capability for jokes

## 🙌 Contributions :
We welcome contributions to improve this project, Whether you want to fix a bug, implement a new feature, or suggest an enhancement, we're open to your ideas. Please create the issue at [here](https://github.com/swapnil-musale/JetJoke/issues) & If you have implemented some changes then raise the Pull request over ```development``` branch.

## 🤝 acknowledgement :
JetJoke project use [Joke API](https://sv443.net/jokeapi/v2/) to fetch and display joke's in app.

## Connect with me:
[![Github Profile](https://skillicons.dev/icons?i=github)](https://github.com/swapnil-musale)
[![LinkedIn](https://skillicons.dev/icons?i=linkedin)](https://linkedin.com/in/swapnil-musale)

## License :
```
MIT License

Copyright (c) 2023 Swapnil Musale

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

</br>
