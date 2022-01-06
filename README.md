TaassApiGateway

Oggetti
1)UserAndData 
{
  userInformation: oggetto User
  userInformation: oggetto userData
}

2)User
{
    "id": 1
    "name": "gabriele",
    "surname": "naretto",
    "email": "gabriele@gmail.com",
    "password": "1234"
}

3)userData
{
    "id": "1234",
    "idUser": "1",
    "topicList": []
}
4)newTopic
{
    "id":"1",
    "name":"palestra",
    "description":"topic che descrive i miei allenamenti i palestra",
    "nameType": 
    [{
    "name":"esercizio",
    "data":"Text"
    },{
    "name":"recupero",
    "data":"Integer Number"
    }],
    "color":["#f44336", "#ff6154", "#ff574a"],
    "shared":false
}

5)newRgistration
{
    "userId" : "1",
    "topic" : "palestra",
    "dataList" : ["banana","60"]
}


Elenco di api e cosa ritornano 
1)http://localhost:8080/gateway/create : ritorna l'oggetto UserAndData
2)http://localhost:8080/gateway/login : ritorna l'oggetto UserAndData é prende un oggetto user con email e password validi
3)http://localhost:8080/gateway/topicUser : ritorna l'oggetto userdata e prende un oggetto userData che neccessiuta dell'id dell'utente
4)http://localhost:8080/gateway/newTopic : ritorna l'oggetto userData e prende l'oggetto newToic 
5)http://localhost:8080/gateway/newReg : ritorna l'oggetto userData e prende l'oggetto newRegistration
6)http://localhost:8080/gateway/delTopic : ritorna un oggetto userData e prende un oggetto user data in cui l'id deve essere dell





