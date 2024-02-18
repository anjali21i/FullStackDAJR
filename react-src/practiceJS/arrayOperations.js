// import { userRecArray } from "./dummyDataSets";
var userRecArray = [];
let userMap = userRecArray.map((item, index, arr) => {
    return console.log("item:", item, "index:", index, "arr:", arr)
})

document.getElementById('abc').innerHTML = userMap;
console.log(userMap);