function getTime(){
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth();
    var day = date.getDate();
    var hours = date.getHours();
    var minutes = date.getMinutes()+15;
    if(minutes > 60){
        hours = hours + 1;
        minutes = minutes - 60;
    }
    var seconds = date.getSeconds();
    if(month<10){
        month = "0"+month;
    }
    if(day<10){
        day = "0"+day;
    }
    if(hours<10){
        hours = "0" + hours;
    }
    if(minutes<10){
        minutes = "0" + minutes;
    }
    if(seconds<10){
        seconds = "0" + seconds;
    }
    return year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
}