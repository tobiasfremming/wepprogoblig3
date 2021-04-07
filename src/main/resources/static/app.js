
//const submitBtn = document.getElementById("submitBtn").addEventListener("click", saveTickets)



const saveTickets = (e) => {
    e.preventDefault();

    let ticket = {
        movie: $("#movie").val(),
        amount: $("#amount").val(),
        firstName: $("#firstName").val(),
        lastName: $("#lastName").val(),
        phone: $("#phone").val(),
        email : $("#email").val()
    }



    $.post("/save", ticket, function(data){

        renderTickets(data);
    });

    $("#movie").html("<option value='' disabled selected >Velg film</option>\n" +
        "            <option value='Interstellar'>Interstellar</option>\n" +
        "            <option value='Inception'>Inception</option>\n" +
        "            <option value='Cars'>Cars</option>");

    $("#amount").val("");
    $("#firstName").val("");
    $("#lastName").val("");
    $("#phone").val("");
    $("#email").val("");


}

function loadTickets(){


    $.get("/load", function(data){

        renderTickets(data)
    });
}


function renderTickets(data){
    

    
    let out = "<table class=\"table\" ><tr><th>Film</th>" +
        "<th scope=\"col\">Antall</th>" +
        "<th scope=\"col\">Fornavn</th>" +
        "<th scope=\"col\">Etternavn</th>" +
        "<th scope=\"col\">Telefonnr</th>" +
        "<th scope=\"col\">epost</th>" +
        "</tr>";
    for (let i = 0; i <data.length; i++) {
        out += "<tr><td>" + data[i].movie +
            "</td><td>" + data[i].amount +
            "</td><td>" + data[i].firstName +
            "</td><td>" + data[i].lastName +
            "</td><td>" + data[i].phone +
            "</td><td>" + data[i].email +
            "</td></tr>";
    }
    out += "</table>";


    $("#output").html(out);

}

function deleteTickets(){
    $.get("/delete", function(){
        $("#output").html("");
    });
}

const formAction = document.querySelector("form")
formAction.addEventListener("submit", saveTickets)

const displayBtn = document.getElementById("displayBtn").addEventListener("click", loadTickets)





