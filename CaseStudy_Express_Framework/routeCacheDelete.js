//Reference: https://www.youtube.com/watch?v=xZ_Rnh1UHTs&t=307s&ab_channel=HeyNode
//Reference2: https://www.npmjs.com/package/node-cache

module.exports = (cache) => (req, res, next) => {

    // is request a Delete?
    // is not, call next...
    if( req.method !== 'DELETE'){
        console.error('Cannot delete non-delete methods!');
        return next();
    }
    // if yes
    // check it key exists in cache
    const key = req.originalUrl;
    const cachedResponse = cache.get(key); // get from cache
    // if it's exist, delete it!
    if(cachedResponse){
        try {
            cache.del(key);
            console.log(`Delete cache for ${key}`);
            return res.send(`Delete ${req.params.region},${req.params.city} Successfully`)
        } catch (e) {
            console.error(e);
            return res.send(`${e}`);
        }
        // return response immediately
    } else {
    // if not,
        console.log(`Nothing to delete for ${key}`);
        return res.send(`Don't have a cache for ${req.params.region},${req.params.city}, Cannot be delete`)
    }
}