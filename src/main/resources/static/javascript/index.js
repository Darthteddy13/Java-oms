//DOM elements
const orderTable = document.getElementById("order_table");

//Modal elements



const headers =
    {
        'Content-Type': 'application/json',
    }

const baseUrl = "http://localhost:8080/"

const getOrders = async () =>
{
    await fetch(`${baseUrl}orders`,
    {
        method: "GET",
        headers:headers
    })
        .then(res => res.json())
        .then(data => addOrders(data))

}

const addOrders = arr =>
{
    arr.forEach(e =>
    {
        orderTable.append(
            `<tr>
                <td>${e.id}</td>
                <td>${e.cust.name}</td>
             </tr>
        `)
    })
}

getOrders();
