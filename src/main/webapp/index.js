import "./style.css"
import "bootstrap/dist/css/bootstrap.css"
import * as bootstrap from 'bootstrap';
import '@popperjs/core';
import lootFacade from "./lootFacade";

updateLoottable();

function updateLoottable() {

    lootFacade.getLoot().then(lootList => {
      const lootRow = lootList.map(loot => `${createLootRow(loot)}`)
      lootRow.reverse()
      const lootListAsString = lootRow.join("")
      document.getElementById("allLootRows").innerHTML = lootListAsString;
    })
}




function createLootRow(loot){
  return `
    <tr>
      <td>${loot.id}</td>
      <td>${loot.playerName}</td>
      <td>${loot.area}</td>
      <td>${loot.lootDescription}</td>
      <td><input id="${loot.id}" type="button"  name="delete" value="delete"/></td>
    </tr>

  `
}

function addLoot(){
  const data = {
    playerName: document.getElementById("PlayerName").value,
    area: document.getElementById("Area").value,
    loot: document.getElementById("loot").value
  }

  lootFacade.addLoot(data).then(updateLoottable());

}


document.getElementById("addLootBtn").addEventListener('click',addLoot);

document.getElementById("allLootRows").addEventListener('click', e => {
  e.preventDefault();
  const node = e.target;
  const name = node.getAttribute("name")
  const id = node.getAttribute("id")
  switch (name) {
    case "delete": lootFacade.deleteLoot(id); break;
  }
})



function hideAllShowOne(idToShow)
{
  document.getElementById("about_html").style = "display:none"
  document.getElementById("ex1_html").style = "display:none"
  document.getElementById("ex2_html").style = "display:none"
  document.getElementById("ex3_html").style = "display:none"
  document.getElementById(idToShow).style = "display:block"
}

function menuItemClicked(evt)
{
  const id = evt.target.id;
  switch (id)
  {
    case "ex1": hideAllShowOne("ex1_html"); break
    case "ex2": hideAllShowOne("ex2_html"); break
    case "ex3": hideAllShowOne("ex3_html"); break
    default: hideAllShowOne("about_html"); break
  }
  evt.preventDefault();
}
document.getElementById("menu").onclick = menuItemClicked;
hideAllShowOne("ex3_html");



