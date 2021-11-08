const express = require('express');
const app = express();
const port = 3000;      // selecting port


const NodeCache = require('node-cache');
const cache = new NodeCache();

//Middleware or Proxy
const cacheGet = require('./routeCache');
const cacheDelete = require('./routeCacheDelete');
const fetch = require('node-fetch');

const root = '/api';

const example = ["Asia/Almaty","Asia/Amman","Asia/Anadyr","Asia/Aqtau","Asia/Aqtobe","Asia/Ashgabat","Asia/Atyrau","Asia/Baghdad","Asia/Baku","Asia/Bangkok","Asia/Barnaul","Asia/Beirut","Asia/Bishkek","Asia/Brunei","Asia/Chita","Asia/Choibalsan","Asia/Colombo","Asia/Damascus","Asia/Dhaka","Asia/Dili","Asia/Dubai","Asia/Dushanbe","Asia/Famagusta","Asia/Gaza","Asia/Hebron","Asia/Ho_Chi_Minh","Asia/Hong_Kong","Asia/Hovd","Asia/Irkutsk","Asia/Jakarta","Asia/Jayapura","Asia/Jerusalem","Asia/Kabul","Asia/Kamchatka","Asia/Karachi","Asia/Kathmandu","Asia/Khandyga","Asia/Kolkata","Asia/Krasnoyarsk","Asia/Kuala_Lumpur","Asia/Kuching","Asia/Macau","Asia/Magadan","Asia/Makassar","Asia/Manila","Asia/Nicosia","Asia/Novokuznetsk","Asia/Novosibirsk","Asia/Omsk","Asia/Oral","Asia/Pontianak","Asia/Pyongyang","Asia/Qatar","Asia/Qostanay","Asia/Qyzylorda","Asia/Riyadh","Asia/Sakhalin","Asia/Samarkand","Asia/Seoul","Asia/Shanghai","Asia/Singapore","Asia/Srednekolymsk","Asia/Taipei","Asia/Tashkent","Asia/Tbilisi","Asia/Tehran","Asia/Thimphu","Asia/Tokyo","Asia/Tomsk","Asia/Ulaanbaatar","Asia/Urumqi","Asia/Ust-Nera","Asia/Vladivostok","Asia/Yakutsk","Asia/Yangon","Asia/Yekaterinburg","Asia/Yerevan"]

// RECOMMENDED: USE POSTMAN !!! 

// This is example /api/timezone/Region/City
// Usage: http://www.localhost:3000/api/timezone/asia/bangkok
// You can change Region and City upon user request.

// This is example /api/delete/timezone/Region/City
// Usage: http://www.localhost:3000/api/timezone/asia/bangkok
// You can change Region and City upon user request.

//Get route
app.get(root+'/timezone/:region/:city', cacheGet(cache,120), async (req, res) => { // 120 seconds of cache

    //Reference: https://stackoverflow.com/questions/21497639/how-to-get-id-from-url-in-express-param-and-query-doesnt-seem-to-work
    const url = `http://worldtimeapi.org/api/timezone/${req.params.region}/${req.params.city}`;
    const options = {
        "method": "GET",
    };

    const response = await fetch(url,options)
        .then(res => res.json())
        .catch(e => {
            console.error(e);
        })

    res.json(response);
})

//Delete route
app.delete(root + '/timezone/:region/:city', cacheDelete(cache), () => {})

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}${root}`);
})


// app.post('/', function (req, res) {
//     res.send('Got a POST request')
// })

// app.put('/user', function (req, res) {
//     res.send('Got a PUT request at /user')
//   })

