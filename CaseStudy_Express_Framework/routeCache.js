//Reference: https://www.youtube.com/watch?v=xZ_Rnh1UHTs&t=307s&ab_channel=HeyNode
module.exports = (cache, duration) => (req, res, next) => {

    // is request a GET?
    // is not, call next...
    if( req.method !== 'GET'){
        console.error('Cannot cache non-Get methods!');
        return next();
    }
    // if yes
    // check it key exists in cache
    const key = req.originalUrl;
    const cachedResponse = cache.get(key); // get from cache

    // if it's exist, send cache result
    if(cachedResponse){
        console.log(`Cache hit for ${key}`);
        var tempCached = JSON.parse(cachedResponse)
        return res.json(tempCached);
        // return response immediately
    } else {
    // if not, replace .send with method to set response to cache 
        console.log(`Cache miss for ${key}`);
        try {
            res.originalSend = res.send;
            res.send = body => {
                res.originalSend(body);
                cache.set(key, body, duration);
            };
            
        } catch (error) {
            console.error(e);
            return res.send(`${e}`);
        }
        return next(); // move into Get Request method
    }
}