function solve(input) {
  input = String(input);

  let result = true;
  let sum = 0;

  let first = input[0];
  for (let index = 0; index < input.length; index++) {
      sum += Number(input[index]);

      if (input[index] !== first) {
          result = false;
      }
  }

  console.log(result);
  console.log(sum);
}
 solve(2222222);
 solve(1234);
 