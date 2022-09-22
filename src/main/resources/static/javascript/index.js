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
        content += `<tr><td>${e.id}</td><td>${e.cust.name}</td></tr>`
        orderTable.innerHTML = content;
    })
}

getOrders();
