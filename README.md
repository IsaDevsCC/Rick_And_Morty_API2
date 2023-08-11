# <h1 style="text-align: center; color : blueviolet; font-family : Courier New;">RICK  AND  MORTY  API<h1>

<div align="center"><img src="src/main/res/drawable/logo.png"></div>
<div>

<h2  style="font-family : Courier New; font-size : 25px;">Created by :</h2>

- Isabel Calzadilla.

<!-- TOP ANCHOR WITH ID TO CALL -->
<a href="#top" id="top"></a>

<h2 style="font-family : Courier New; font-size : 25px;">Menu : </h2>

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#sintesis">About the Project</a>
      <ul>
        <li><a href="#tecnologias">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#aplicacion">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#modelo1">Use Case Diagram</a></li>
  </ol>
</details>

<h2 style="font-family : Courier New; font-size : 25px;" id="sintesis">About the Project</h2>

<br />
<div align="center">
  <p align="center">
    Requirements!


<details>
  <ol>
    <li>
      <ul>
        <li>Compose / AVS.</li>
        <li>Inyección de dependencias.</li>
        <li>Koin.</li>
        <li>Retrofit.</li>
        <li>Repository pattern</li>
        <li>Moshi.</li>
        <li>MVVM.</li>
        <li>Corutines.</li>
        <li>Gestión de Estilos.</li>
        <li>Unit Test.</li>
        <li>Custom Views.</li>
      </ul>
    </li>
  </ol>
</details>


</div>


<p align="right">(<a href="#top" >back to top</a>)</p>

<h2 style="font-family : Courier New; font-size : 25px;" id="tecnologías">Tools</h2>


<details>
  <ol>
    <li>
      <a href="#"> Develop :</a>
      <ul>
        <li>Java 17.</li>
        <li>Kotlin.</li>
        <li>Android Studio.</li>
        <li>Retrofit.</li>
        <li>Room.</li>
        <li>Moshi.</li>
      </ul>
    </li>
    <li>
      <a href="#"> Visual :</a>
      <ul>
        <li>AVS</li>
        <li>Compose</li>
      </ul>
    </li>
  </ol>
</details>


<p align="right">(<a href="#top">back to top</a>)</p>


<h2 style="font-family : Courier New; font-size : 25px;" id="aplicacion">Install : </h2>

### Prerequisites

* IDE  compatible

### Installation

1. Clone the repo
    ```sh
   git git@github.com:IsaDevsCC/Rick_And_Morty_API2.git
   ```
2. Install graddle packages

3. Start the app

4. ?????

5. Profit

<p align="right">(<a href="#top" >back to top</a>)</p>


<h2 style="font-family : Courier New; font-size : 25px;" id="usage">How to Use</h2>

1. Select a command from panel (we recommended add new values to the storage).

<div align="center"><img src="src/img/menu.png"></div>

2. Create the instances of Lead with every value

<div align="center"><img src="src/img/name.png"></div>

3. Check that new value was added correctly

<div align="center"><img src="src/img/leadOk.png"></div>

4. Follow with the exactly commands of menu.

- Check All Leads

<div align="center"><img src="src/img/allLeads.png"></div>

- Or another command

<div align="center"><img src="src/img/opportunities.png"></div>

<p align="right">(<a href="#top" >back to top</a>)</p>

<h2 style="font-family : Courier New; font-size : 25px;" id="modelo1">Use Case Diagram</h2>

The use case show how a user could do it different opperations in the CRM, just with a few command lines.

### Available Operations :


- Login.
- Character's List.
- Filter Character's List.
- Delete Character.
- Character's Details.
- Add Characters to favorites.
- Favorites List.
- Add New Character.
- Reset List.



<p align="right">(<a href="#top" >back to top</a>)</p>

<h2 style="font-family : Courier New; font-size : 25px;" id="modelo2">Class Diagram</h2>

### The Class in the Application are:

#### Basic Instances

- Character.
- CharacterDTO.
- CharacterDAO.


<p align="right">(<a href="#top">back to top</a>)</p>

<h2 style="font-family : Courier New; font-size : 25px;" id="modelo3">Arch Diagram</h2>

#### Logic of Bussiness

##### Use Case

- AddToFavUseCase.
- DeleteCharacterByIdUseCase.
- GetCharacterDetailUseCase.
- GetCharacterListUseCase.
- GetFavListUseCase.
- GetNewCharacterUseCase.
- ResetListUseCase.


##### Interfaces

- LocalDataSource.
- ApiDataSource.
- ApiDAO.
- ApiClient.
- DataRepository.


##### Dependency Injection

- dataModule.
- domainModule.
- presentationModule.



<p align="right">(<a href="#top">back to top</a>)</p>

</div>

