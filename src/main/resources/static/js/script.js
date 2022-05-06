////window.onload = updateClock;
////window.onload = updateClock;
// Script created by Andr7st.
var am       = document.getElementById('lblMeridiano').innerHTML;
var horas    = document.getElementById('lblHora').innerHTML;
var minutos  = document.getElementById('lblMinuto').innerHTML;
var segundos = document.getElementById('lblSegundo').innerHTML;

function uHora() {
    if (horas == 12 && am == "PM") { am = "AM"; horas = 0; }
    if (horas == 12 && am == "AM") { am = "PM"; horas = 0; }

    horas++;
    var miHora = /*"00" +*/ horas;
    //document.getElementById('hh').innerHTML = miHora.slice(-2);
    document.getElementById('hh').innerHTML = miHora;
    document.getElementById('pm').innerHTML = am;
}

function uMinuto() {
    while (minutos == 59) { uHora(); minutos = -1; }
    minutos++;
    var miMinuto = "00" + minutos;
    document.getElementById('mm').innerHTML = miMinuto.slice(-2);
}

function updateClock() {

    if (segundos == 59) { 
        uMinuto();
        segundos= -1; 
    } 
    else {
        //var miHora = "00" + horas;
        //document.getElementById('hh').innerHTML = miHora.slice(-2);

        if (horas == 0) {
            horas = 12;
        }

        document.getElementById('hh').innerHTML = horas;
        var miMinuto = "00" + minutos;
        document.getElementById('mm').innerHTML = miMinuto.slice(-2);
        document.getElementById('pm').innerHTML = am;
    }

    segundos++;
    setTimeout("updateClock()", 1000);
    var cadena = "00" + segundos;
    document.getElementById('ss').innerHTML = cadena.slice(-2);
}

updateClock();