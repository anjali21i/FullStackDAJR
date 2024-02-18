let b= "k";
var tyiii =0;
//
console.log(a)
var a = 5;

console.log(a);
console.log(this);
const fg = () => {
    let obj = {
        l:"l",
        po:"op"
    }
    return obj;
}
function mm() {
    let obj = {
        l:"l",
        po:"op"
    }
    return obj;
}
const ggg = function mm() {
    let obj = {
        l:"l",
        po:"op"
    }
    return obj;
}
let mmy = mm;
console.log(mm);
console.log(mmy);
console.log(mmy());
console.log(mm());
console.log(fg());
console.log(()=> mm());
console.log(()=> fg());
