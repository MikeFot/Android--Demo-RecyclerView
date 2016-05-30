# Android Demo RecyclerView
Demo Android Material Design application showcasing a single activity with a RecyclerView and Cards.

## Structure
The application is using 2 modules: 
- core: contains internal data providers and core business logic
- app: contains base UI components, their implementations and dedicated data loaders.

## Core

### Data Retrieval
Asynchronous calls using Retrofit 2.

### Deserialisation
Using GSON with a custom Type Adapter Factory mapping interfaces to implementations.

## App
### Base Components
- Using AppCompat.
- Activities and Fragments have their own Intent Dispatcher and Image Fetcher instances which they provide to their data binders.

### Data Loading
- Using a data loader which is calling the Core Data Provider on a background thread, then notifying the caller on the UI thread.
- Internal error conversion is handled by an Error Factory.
- API objects get converted to UI objects using adapters.

### Recycler Views
- Recycler Views have a UI State Coordinator attached to them which handles empty, error and with data states.

### Colour Name Loading
Modification of https://gist.github.com/XiaoxiaoLi/8031146

## Libraries
Butterknife, Picasso, Retrofit 2, AutoFitTextView, GSON, Mockito

## Screenshots
Home Screen (API 22 Portrait)

![Alt text](/screens/api_22_portrait.png?raw=true "Home Screen (API 22 Portrait)")

Home Screen (API 22 Landscape)

![Alt text](/screens/api_22_landscape.png?raw=true "Home Screen (API 22 Landscape)")

Home Screen (API 19 Portrait)

![Alt text](/screens/api_19_portrait.png?raw=true "Home Screen (API 19 Portrait)")
