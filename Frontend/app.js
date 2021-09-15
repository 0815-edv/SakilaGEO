function updateTable(input) {
    console.log(input)
    $('#table tr:last').after('<tr>...</tr><tr>...</tr>');
}

var cityName = "" 

function getCountryName(id){
    $.getJSON("http://127.0.0.1:8080/get/country?id="+id, function getCity(res) {
        console.log(res.name);
        cityName = res.name;
    });
}

function getData() {
    $.getJSON("http://127.0.0.1:8080/get/cities", function getData(res) {
        res.forEach(entry => {
            console.log(entry)
            getCountryName(entry.countryID)
            $('#tab tr:last').after(`
        <tr>
          <td>${entry.cityID}</td>
          <td>${entry.name}</td>
          <td>${cityName}</td>
        </tr>`);
        });
    });
}
/*
      function submitForm() {
        $.ajax({
          url: "http://127.0.0.1:8080/get/cities",// + $('#town').val(),
          type: 'GET',
          contentType: 'application/json',
          async: false
        });
      }
      */