//DOM Elements
const addItemBtn = document.getElementById("add-item-btn");
const itemTable = document.getElementById("item-table");

const headers =
    {
        'Content-Type': 'application/json',
    }

const baseUrl = "http://localhost:8080"

let orderId = sessionStorage.getItem("id");

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
const newItemSubmit = () =>
{
    let name = document.getElementById("item_name").value;
    let price = document.getElementById("price").value;
    let description = document.getElementById("description").value;

    if( name != null && price != null && description != null) {
        let custObj = {
            name: name,
            description: description,
            price: price
        }
        console.log(custObj)
        return custObj;
    }
    alert("Please make sure name and phone are not empty");
    return false
}

const addItem = async obj =>
{
    console.log(obj)
    if(newItemSubmit())
    {
        await fetch(`http://localhost:8080/items/order/${orderId}`,
            {
                method: "POST",
                body: JSON.stringify(newItemSubmit()),
                headers:headers
            })
            .catch(err => console.error(err.message))
        alert("item added")
        location.reload();
    }
}
addItemBtn.addEventListener("click", addItem)
getItems();