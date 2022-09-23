//DOM elements
const orderTable = document.getElementById("order-table");

//Modal elements



const headers =
    {
        'Content-Type': 'application/json',
    }

const baseUrl = "http://localhost:8080/orders/"

const getOrders = async () =>
{
    await fetch(`${baseUrl}orders`,
    {
        method: "GET",
        headers:headers
    })
        .then(res => res.json())
        .then(data => addOrders(data))
        .catch(err => console.error(err.message))

}

const addOrders = arr =>
{
    arr.forEach(e =>
    {
        let content = orderTable.innerHTML;
        content += `<tr><td onclick="navigate(e.id)">${e.id}</td><td onclick="navigate(e.id)">${e.cust.name}</td></tr>`
        orderTable.innerHTML = content;
    })
}

const navigate = id =>
{
    sessionStorage.setItem("id", id)
    location.href="/order.html"
}
const newOrder = async id =>
{
    let response = await fetch(`${baseUrl}/cust/${id}`,
        {
            method: "POST",
            headers: headers
        })
        .catch(err => console.error(err.message))
}

function addOptions(arr) {
    arr.forEach(e =>
    {
        let content = customerSelect.innerHTML;
        content += `<option value="${e.id}">${e.name}</option>`
        customerSelect.innerHTML = content;
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

//implement new order function. ***Remember to save id to session id***


getOrders();
