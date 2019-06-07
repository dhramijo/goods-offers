PROBLEM DESCRIPTION:
********************
As a merchant, I offer goods for sale. I want to create an offer so that I can share it with my customers. All my offers have shopper friendly descriptions. I price all my offers up front in a defined currency.
An offer is time-bounded, with the length of time an offer is valid for
defined as part of the offer, and should expire automatically. Offers may
also be explicitly canceled before they expire.
***********
ASSIGNMENT:
***********
Create a simple RESTful software service that will allow a merchant to create a new simple offer. Offers, once created, may be queried. After the period of time defined on the offer, it should expire and further requests to query the offer should reflect that somehow. Before an offer has expired users may cancel it.
*********
ANALYSIS:
*********
The REST API shoul be able to:
* Register a new offer
* Find one or more offers
* Delete an offer
*******
DESIGN: 
*******
MVC architecture:
- Model: Offers
  * int id;
  * String name;
  * String description;
  * double price;
  * String currency;
  * Date startDate;
  * int offerDaysDuration;
  * boolean expired;

- View: Postman
- Controller: OffersController with REST API
- Service: OffersService with CRUD operation
***************
IMPLEMENTATION:
***************
- Spring Boot 2
- H2 database
- model.Offers.java
- controller.OffersController.java
- service.OffersService.java
********
TESTING:
********
The DB should be empty in order to start the tests.
REST API endpoint: http://localhost:8080/offer
Use the following JSON for the POST request:

	{
        "name": "GW2",
        "description": "GW2 Offer",
        "price": 29.90,
        "currency": "Eur",
        "startDate": "2019-04-03T14:56:59.301+0000",
        "offerDaysDuration": 20,
        "expired": true
    }

1) Test Pattern:
- Create new Offer
- List all active Offers
   * Assert if the Offer is in the List
- Delete the active offer
   * Assert if the List is Empty
***********************************************
2) Sanity Testing:
- Assert if the Spring Context is Running 
- Assert if the OfferController is Alive
***********************************************
3) System Testing:
- Test the complete OfferApplication
- Use RestTemplate as Client (same role as Postman)
- RestTemplate class:
   * postForEntity(url, offer, Offer[].class)
   * getForObject(url, Offer[].class)
   * delete(url)
**************************************************
4) Integration Testing:
- Test OffersController and OffersService
****************************************************
5) JPA Testing:
- Test the OffersService
- DB
****************************************************
6) Unit Testing:
- Test Standalone Controller
- Mock the OffersService
- Using Mockito
  * when(call).thenReturn(mock)
