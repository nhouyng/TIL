# Android alert

```java
AlertDialog.Builder alert = new AlertDialog.Builder(this);
alert.setTitle("타이틀");
        
alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
    }
});
alert.setNegativeButton("취소", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface arg0, int arg1) {
    }
});
alert.show();
```
