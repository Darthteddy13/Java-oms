//DOM elements
const orderTable = document.getElementById("order-table");
const customerSelect = document.getElementById("customer_select");
const newCustBtn = document.getElementById("new-customer");
const newOrderBtn = document.getElementById("new-order-btn")
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
        content += `<tr><td onclick="navigate(${e.id})">${e.id}</td><td onclick="navigate(${e.id})">${e.cust.name}</td></tr>`
        orderTable.innerHTML = content;
    })
}

const navigate = id =>
{
    sessionStorage.setItem("id", id)
    location.href="/order.html"
    console.log("clicked")
}

const addOptions = arr =>
{
    arr.forEach(e =>
    {
        let content = customerSelect.innerHTML;
        content += `<option value="${e.id}">${e.name}</option>`
        customerSelect.innerHTML = content;
    })
}

const customerOptions = async () =>
{
    await fetch(`http://localhost:8080/Cust/customers`,
        {
            method: "GET",
            headers:headers
        })
        .then(res => res.json())
        .then(data =>  addOptions(data))
        .catch(err => console.error(err.message))

}

const whatSelected = () =>
{
    if(customerSelect.options[customerSelect.selectedIndex].value !== "emptySelect")
    {
        console.log(customerSelect.options[customerSelect.selectedIndex].value);
        return customerSelect.options[customerSelect.selectedIndex].value;

    }
    else
    {
        alert("No customer selected. Please use drop down to select a customer.")
        return false;
    }
}

//implement new order and new customer functions. ***Remember to save id to session id***
const newOrder = async () => {
    if(whatSelected())
    {
        await fetch(`${baseUrl}cust/${whatSelected()}`,
            {
                method: "POST",
                headers:headers
            })
            .catch(err => console.error(err.message))
        alert("Order Created")
        location.reload();
    }
}

const newCustSubmit = () =>
{
    console.log(document.getElementById("name").value)
    if(document.getElementById("name").value != null && document.getElementById("phone").value != null) {
        let custObj = {
            name: document.getElementById("name").value,
            phoneNumber: document.getElementById("phone").value,
            email: document.getElementById("email").value
        }
        console.log(custObj)
        return custObj;
    }
        alert("Please make sure name and phone are not empty");
        return false
}

const addCust = async obj =>
{
    console.log(obj)
    if(newCustSubmit())
    {
        await fetch(`http://localhost:8080/Cust/register`,
            {
                method: "POST",
                body: JSON.stringify(newCustSubmit()),
                headers:headers
            })
            .catch(err => console.error(err.message))
        alert("Customer added")
    }
    location.reload();
}

newCustBtn.addEventListener("click", addCust)
newOrderBtn.addEventListener("click", newOrder)
customerOptions();
getOrders();
