[![Jcenter Status](https://api.bintray.com/packages/openproject/maven/lesscode-debug/images/download.svg)](https://bintray.com/openproject/maven/lesscode-debug)

# LessCode-Debug
a common ui for app debug info to show or something else

## Gradle

```groovy
compile('com.jayfeng:lesscode-debug:2.0');
```

## Overview
> * 简单清晰
> * 易于扩展
> * 开源

## Usage
继承DebugActivity，重载fillValues(List<DebugKV> debugKVList)方法：
```java
public class MyDebugActivity extends DebugActivity {

    @Override
    protected void fillValues(List<DebugKV> debugKVList) {
        debugKVList.add(new DebugKV("UserToken", "11111111111111111111"));
        debugKVList.add(new DebugKV("UserToken2", "2222"));
        debugKVList.add(new DebugKV("UserToken3", "333"));
        debugKVList.add(new DebugKV("UserToken4", "444"));
        debugKVList.add(new DebugKV("UserToken5", "11111111111111111111"));
        debugKVList.add(new DebugKV("UserToken6", "11111111111111111111"));
        debugKVList.add(new DebugKV("UserToken7", "11111111111111111111"));
        debugKVList.add(new DebugKV("AndroidId", "next to do"));
    }

    @Override
    protected void fillApiValues(List<DebugApi> debugApiList) {
        debugApiList.add(new DebugApi("通用 - 全局字典", "common/dict", new DebugApiCallBack() {
            @Override
            public void invoke(Context context, DebugApi debugApi, RecyclerView.Adapter adapter) {
                updateDebugApiToFailure(debugApi, adapter);
                Toast.makeText(context, "tttttttttttttttttt", Toast.LENGTH_SHORT).show();
                showDebugApiLog("xxxxx");
            }
        }));
        debugApiList.add(new DebugApi("通用 - 检查更新", "common/update", new DebugApiCallBack() {
            @Override
            public void invoke(Context context, DebugApi debugApi, RecyclerView.Adapter adapter) {
                updateDebugApiToSuccess(debugApi, adapter);
                Toast.makeText(context, "ooiiiiiii", Toast.LENGTH_SHORT).show();
            }
        }, false));
    }
}
```

## Author

> Author weibo：<a href="http://weibo.com/xiaofengjian" target="_blank">冯建V</a>&nbsp;&nbsp;&nbsp;&nbsp;mail：673592063@qq.com&nbsp;&nbsp;&nbsp;&nbsp;QQ：673592063

## License

```
Copyright (C)  LessCode Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
