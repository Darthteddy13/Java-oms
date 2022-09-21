//DOM Elements
const itemsContainer = document.getElementById("items-container");
const newCustBtn = document.getElementById("new-customer");
const customerSelect = document.getElementById("customer_select");

const headers =
    {
        'Content-Type': 'application/json',
    }

const baseUrl = "http://localhost:8080"

function addOptions(arr) {
    arr.forEach(e =>
    {
        customerSelect.append(
            `<option value="${e.id}">${e.name}</option>
        `)
    })
}

const customerOptions = async () =>
{
    await fetch(`${baseUrl}/Cust/customers`,
        {
            method: "GET",
            headers:headers
        })
        .then(res => res.json())
        .then(data => addOptions(data))
        .catch(err => console.error(err.message))
}
customerOptions();

