let a = 8;
// let a = 87;   //gives err block is same

var b = 4;
let b = 4;

let c = 89;
// var c = 8;     //error at c as => shadowing done as its blocked scoped in first declaration 

if(true) {
    // var a = 44;
    let a = 43;  //wont give error as block is diff
    let b = 433;
}