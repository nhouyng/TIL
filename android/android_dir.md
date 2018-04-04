# Android Directory
### directory 생성
dir 생성을 위해 manifests.xml에 아래 코드를 추가하는데
```xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```
이건 단지 권한 요청이고 생성을 위해서는 스마트폰 설정 -> 앱 관리 -> 생성한 앱 선택 -> 권한 설정에서 권한을 수동으로 설정하던가 alert을 통해 앱이 켜지면서 사용자에게 동의를 받는 방법이 있는듯

권한 설정을 마치고 directory의 경로만들기 경로는 /Android/패키지명/directory이름 경로를 권고한다는데 실제로 경로로 들어가면 여러 앱들이 위와같은 방법으로 경로를 지정해둠
```java
public static String dirPath = Environment.getExternalStorageDirectory().getAbsoluteFile() + "/Android/com.mosslife.studyapp01/temp";
```

경로 설정마쳤으면 directroy 생성, MainActivity의 onCreate에서 수행하는게 적합한 위치인것같음. 사용자가 앱을 설치하고 실행하자마자 directory를 깔아?버리는거지
```java
File file = new File(dirPath);
  if(!file.exists())
    file.mkdirs();
```
***
### 텍스트(.txt) 파일 쓰기
이어서 파일 내용을 추가할때
```java
public void writeTextFile(String filename, String contents){
        try{
            FileOutputStream fos = new FileOutputStream(dirPath+"/"+filename, true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(contents);
            bw.flush();

            bw.close();
            fos.close();
        }catch (Exception e){
            Log.v("writeTextFile ERROR", e.toString());
        }

    }
```
파일 내용을 덮어씌우고 싶다면
```java
public void writeTextFile(String contents) {
    try {
        FileWriter fw = new FileWriter(dirPath +"/"+fileName);
        fw.write(contents);
        fw.close();
    } catch (Exception e) {
        Log.v("writeTextFile ERROR", e.toString());
    }
}
```
***
### 텍스트(.txt) 파일 읽기
```java
public String readTextFile(String filename) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            InputStream is = new FileInputStream(dirPath + "/" + filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = "";
            while ((line = br.readLine()) != null) {
                stringBuffer.append(line + "\n");
            }

        } catch (Exception e) {
            Log.i("readTextFile", e.toString());
        }

        return stringBuffer.toString();
    }
```
***
### directory안의 file 이름 가져오기
```java
File dir = new File(dirPath);
File[] files = dir.listFiles();
List<String> filesNameList = new ArrayList<>();
for (File file : files) {
  filesNameList.add(file.getName());
}
```
***
### ListView

1. xml에 ListView 만들기
```xml
<ListView
        android:id="@+id/lv"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
</ListView>
```
2. ListView에 들어갈 목록 이름?을 list(ArrayList)에 담기
3. ArrayAdapter를 만들어서 list 저장
```java
ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, filesNameList);
```
4. ListView의 setAdapter를 통해 list를 저장한 adapter 뿌리기
```java
ListView listView = (ListView) findViewById(R.id.lv);
listView.setAdapter(adapter);
```

list의 item에 대한 Listener
```java
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    // item 이름 가져오기
    String filename = (String) parent.getItemAtPosition(position);
  }
});
```
***
### 화면(Activity) 전환 Intent
Intent를 이용한 화면전환
```java
Intent intent = new Intent(MainActivity.this, NextActivity.class);
// Activity 전환시 data 전달
intent.putExtra("key",value);
startActivity(intent);
```
NextActivity에서 MainActivity에서 보낸 value 받기
```java
Intent intent = getIntent();
String value = intent.getStringExtra("key");
```
***
### EditText
1. 키보드 보이기
```java
InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
```
2. 키보드 숨기기
```java
InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0);
```
3. 커서 위치는 gravity로
```xml
<EditText
  android:id="@+id/edittext"
  android:hint="내용을 입력하세요."
  android:gravity="top"
  android:layout_width="match_parent"
  android:layout_height="match_parent" />
```
