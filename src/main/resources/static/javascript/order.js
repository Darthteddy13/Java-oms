//DOM Elements
const newCustBtn = document.getElementById("new-customer");
const customerSelect = document.getElementById("customer_select");
const itemTable = document.getElementById("item-table");

const headers =
    {
        'Content-Type': 'application/json',
    }

const baseUrl = "http://localhost:8080"

let orderId = sessionStorage.getItem(id);
sessionStorage.clear();

const popItems = arr =>
    {
        arr.forEach(e =>
        {
            let content = itemTable.innerHTML;
            content += `<tr><td>${e.name}</td><td>${e.description}</td><td>${e.price}</td></tr>`;
            itemTable.innerHTML = content;
        })
    }
const getItems = async () =>
    {
        await fetch(`${baseUrl}/items/order/${orderId}`,
            {
                method: "GET",
                headers:headers
            })
            .then(res => res.json())
            .then(data => popItems(data))
            .catch(err => console.error(err.message))
    }

//implement add item

getItems();
