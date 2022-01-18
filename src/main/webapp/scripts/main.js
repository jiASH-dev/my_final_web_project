let buttonAddElement = document.getElementById('buttonAddEvent');
let flexAdd = document.getElementById('add_form');

buttonAddElement.onclick = function () {

    let addName = document.createElement('input');
    addName.name = 'eventNames';
    addName.type = 'text';
    addName.placeholder = 'Введите название события';
    addName.className = 'add_element';

    let timeWrapper = document.createElement('div');
    timeWrapper.className = 'timesBox';

    let addTimeStart = document.createElement('input');
    addTimeStart.name = 'timesStart';
    addTimeStart.type = 'time';
    addTimeStart.className = 'time_input';

    let addTimeEnd = document.createElement('input');
    addTimeEnd.name = 'timesEnd';
    addTimeEnd.type = 'time';
    addTimeEnd.className = 'time_input';

    timeWrapper.appendChild(addTimeStart);
    timeWrapper.appendChild(addTimeEnd);

    let childBefore = flexAdd.childNodes[flexAdd.childNodes.length-4];

    flexAdd.insertBefore(addName, childBefore);
    flexAdd.insertBefore(timeWrapper, childBefore);
}
