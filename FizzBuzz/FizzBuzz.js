for (var i = 1; i <= 100; i++) {
    var fb = "";
    if(i % 3 == 0){
        fb += "Fizz";
    }
    if(i % 5 == 0){
        fb += "Buzz";
    }
    if(fb == ""){
        console.log(i)
    } else {
        console.log(fb);
    }
}
