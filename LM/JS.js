let answer = {
    "displayedName": {
        "displayedName": {
            "value": [
                "Профиль маячковый ПВХ 10 мм L3м"
            ],
            "description": "Полное наименование товара для клиента"
            }
        },
    "stock": {
        "stocks": {
                "34": {
                "2": "35",
                "3": "42",
                "4": "58",
                "5": "57",
                "6": "112",
                "20": "51",
                "22": "78",
                "26": "34",
                "32": "22",
                "35": "358",
                "40": "28",
                "43": "68",
                "45": "58",
                "49": "31",
                "51": "29",
                "56": "42",
                "62": "26",
                "64": "0",
                "65": "57",
                "86": "15",
                "114": "41",
                "117": "46",
                "143": "46",
                "162": "4",
                "171": "0",
                "176": "12"
            }
        }
    }
}

function getName() {
    return answer.displayedName.displayedName.value[0];
}

function getStocks() {
    let arr = [];
    let stocks = answer.stock.stocks["34"];
    for (let key in stocks) {
        if(stocks[key] != 0)
            arr.push(key);
    }
    return arr;
}

function getMax() {
    let max = "2";
    let stocks = answer.stock.stocks["34"];
    for (let key in stocks) {
        if(Number(stocks[key]) > stocks[max])
            max = key;
    }
    return max + ":" + stocks[max];
}

document.body.insertAdjacentHTML("afterbegin", `<div>
    Результаты выполнения методов:
  </div>`);
document.body.insertAdjacentText("beforeend", getName());
document.body.insertAdjacentHTML("beforeend", "<br>");
document.body.insertAdjacentText("beforeend", getStocks());
document.body.insertAdjacentHTML("beforeend", "<br>");
document.body.insertAdjacentText("beforeend", getMax());