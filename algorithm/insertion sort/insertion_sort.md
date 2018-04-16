# 삽입 정렬(insertion sort)
삽입정렬은 배열을 앞에서부터 정렬된 부분과 비교하여 삽입하는 정렬 알고리즘이다.

k 번째 인덱스에 대하여 삽입 정렬할 경우,
배열의 구조는 [k-1까지는 이미 k-1개에 대한 요소들로 정렬된 부분, 선택된 k, k~n까지는 아직 정렬되지 않은 요소들]

시간 복잡도는 O(n^2)이다.

1. k 번째 인수를 k-1 부터 0(역순)으로 비교한다.
2. 자기보다 큰 값(오름차순) h를 만나면 h의 인덱스를 뒤로 하나민다.
3. 자기보다 작은 값을 만나기 전까지 2 반복
4. 자기보다 작은 값을 만나면 작은 값의 다음 인덱스에 k값을 정한다.