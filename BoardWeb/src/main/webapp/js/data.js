/*
 *  data.js
*/

const myMembers = [
    {id:"user01", name:"홍길동", phone:"010-1111-1111", point:90},
    {id:"user02", name:"박석민", phone:"010-2222-2222", point:95},
    {id:"user03", name:"김시후", phone:"010-3333-3333", point:120}
];

const json = `[{"id":1,"first_name":"Rory","last_name":"Belhome","email":"rbelhome0@cnbc.com","gender":"Male","salary":6347},
    {"id":2,"first_name":"Cayla","last_name":"Hearnden","email":"chearnden1@gizmodo.com","gender":"Female","salary":6608},
    {"id":3,"first_name":"Davie","last_name":"Jonsson","email":"djonsson2@mayoclinic.com","gender":"Male","salary":6684},
    {"id":4,"first_name":"Royall","last_name":"Eames","email":"reames3@army.mil","gender":"Male","salary":7910},
    {"id":5,"first_name":"Sibby","last_name":"Antusch","email":"santusch4@nytimes.com","gender":"Female","salary":6929},
    {"id":6,"first_name":"Jeramie","last_name":"Kilgallon","email":"jkilgallon5@google.de","gender":"Male","salary":3230},
    {"id":7,"first_name":"Amelina","last_name":"Vigurs","email":"avigurs6@senate.gov","gender":"Female","salary":5451},
    {"id":8,"first_name":"Merry","last_name":"Gott","email":"mgott7@weebly.com","gender":"Male","salary":4805},
    {"id":9,"first_name":"Ansel","last_name":"McSaul","email":"amcsaul8@google.com.hk","gender":"Male","salary":6670},
    {"id":10,"first_name":"Claudian","last_name":"Iacovini","email":"ciacovini9@buzzfeed.com","gender":"Male","salary":6402},
    {"id":11,"first_name":"Natalina","last_name":"Ogger","email":"noggera@tamu.edu","gender":"Female","salary":5800},
    {"id":12,"first_name":"Rick","last_name":"Pimer","email":"rpimerb@t.co","gender":"Male","salary":4537},
    {"id":13,"first_name":"Bent","last_name":"Embra","email":"bembrac@hc360.com","gender":"Male","salary":6274},
    {"id":14,"first_name":"Antonina","last_name":"Braycotton","email":"abraycottond@instagram.com","gender":"Female","salary":7884},
    {"id":15,"first_name":"Sarene","last_name":"Banting","email":"sbantinge@plala.or.jp","gender":"Female","salary":4487}]`;

    const employees = JSON.parse(json);