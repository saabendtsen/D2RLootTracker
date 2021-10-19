const URL = "http://87.59.207.176/D2RLootTracker/api/loot";


function addLoot(loot){
const options = makeOptions("POST",loot)

return fetch(URL,options).then(res => handleHttpErrors(res))
}


function getLoot(){
    return fetch(URL).then(res => handleHttpErrors(res))
}

function deleteLoot(id){
    const option = makeOptions("DELETE")

return fetch(`${URL}/${id}`,option).then(res => handleHttpErrors(res))
}

const lootFacade = {
    addLoot,
    getLoot,
    deleteLoot
}

function makeOptions(method, body) {
    var opts =  {
      method: method,
      headers: {
        "Content-type": "application/json",
        "Accept": "application/json"
      }
    }
    if(body){
      opts.body = JSON.stringify(body);
    }
    return opts;
   }
   

   function handleHttpErrors(res){
    if(!res.ok){
      return Promise.reject({status: res.status, fullError: res.json() })
    }
    return res.json();
   }
   

export default lootFacade;