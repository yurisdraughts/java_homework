* **abstract class** *Unlocker*
* **interface** *UnlockingMethod\<T\>*

* **public class** *NoPasswordUnlocker* **extends** *Unlocker*
* **public class** *PINUnlocker* **extends** *Unlocker* **implements** *UnlockingMethod\<Integer\>*
* **public class** *FingerprintUnlocker* **extends** *Unlocker* **implements** *UnlockingMethod\<String\>*
* **public class** *FaceIDUnlocker* **extends** *Unlocker* **implements** *UnlockingMethod\<String\>*