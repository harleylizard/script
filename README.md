# script
scripting language supporting math and animation.


## Examples

In Java.
```java
ScriptLoader scriptLoader = ScriptLoader.of(resourceLoader, List.of("my_function.script"));

ScriptInternals internals = scriptLoader.getScript("my_function.script").getInternals();
DataEntry data = internals.getData(scriptLoader, "vector");

Query query = new Query();
DataEntry.Instance position = query.add("position", data);

internals.getFunction("my_function").execute(query);

int x = position.getInt("x");
int y = position.getInt("y");
int z = position.getInt("z");
```


In script files.
```
data vector {
    int x
    int y
    int z
}
```

```
import path/to/my_data.script

function my_function {
    position.x = 0
    position.y = 0
    position.z = 0
}
```

## Future Stuff (Not Implemented Yet)
* Operators (1 + 1, 1 - 1, 1 / 1, 1 * 1, 1 & 1)
* References (1 * myObject.value)
