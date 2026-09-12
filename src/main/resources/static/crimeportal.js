function showcrimers() {
    fetch("http://crime-net-production.up.railway.app/crimeportal")
        .then(response => response.json())
        .then(crimeportal => {

            const datatable = document.getElementById("crimetable");
            datatable.innerHTML = "";

            crimeportal.forEach(crime => {
                let row = `
                    <tr>
                        <td>${crime.caseid}</td>
                        <td>${crime.name}</td>
                        <td>${crime.location}</td>
                        <td>${crime.crimetype}</td>
                        <td>${crime.crimestatus}</td>
                    </tr>
                `;

                datatable.innerHTML += row;
            });
        });
}


// ================= UPDATE CASE =================

let updateForm = document.getElementById("updateForm");

if (updateForm) {

    updateForm.addEventListener("submit", function(event) {

        event.preventDefault();

        let caseid = document.getElementById("caseid").value;
        let name = document.getElementById("name").value;
        let location = document.getElementById("location").value;
        let crimetype = document.getElementById("crimetype").value;
        let crimestatus = document.getElementById("crimestatus").value;

        let url = "http://crime-net-production.up.railway.app/crimeportal/" + caseid
            + "?name=" + encodeURIComponent(name)
            + "&location=" + encodeURIComponent(location)
            + "&crimetype=" + encodeURIComponent(crimetype)
            + "&crimestatus=" + encodeURIComponent(crimestatus);

        fetch(url, {
            method: "PUT"
        })
        .then(response => response.text())
        .then(data => {
            alert(data);
        })
        .catch(error => {
            alert("Error: " + error);
        });

    });
}


// ================= SEARCH BY NAME =================

let searchForm = document.getElementById("searchForm");

if (searchForm) {

    searchForm.addEventListener("submit", function(event) {

        event.preventDefault();

        let name = document.getElementById("name").value;

        fetch("http://crime-net-production.up.railway.app/crimeportal/searchbyname?name="
            + encodeURIComponent(name))

        .then(response => response.json())

        .then(crimes => {

            const datatable = document.getElementById("crimetable");

            datatable.innerHTML = "";

            crimes.forEach(crime => {

                let row = `
                    <tr>
                        <td>${crime.caseid}</td>
                        <td>${crime.name}</td>
                        <td>${crime.location}</td>
                        <td>${crime.crimetype}</td>
                        <td>${crime.crimestatus}</td>
                    </tr>
                `;

                datatable.innerHTML += row;

            });

        })

        .catch(error => {
            alert("Error: " + error);
        });

    });
}
