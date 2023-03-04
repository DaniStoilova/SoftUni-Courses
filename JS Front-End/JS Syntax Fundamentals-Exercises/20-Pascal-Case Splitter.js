function solve(text){


  console.log(text.split(/(?=[A-Z])/g).join(', '));

}
solve('SplitMeIfYouCanHaHaYouCantOrYouCan');
solve('HoldTheDoor');
solve('ThisIsSoAnnoyingToDo');