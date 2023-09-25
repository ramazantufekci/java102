import javax.security.auth.login.AccountLockedException;

public class MyList<T> {
    private Integer capacity;
    private Integer itemSize = 0;
    private T[] list;
    private T[] tempList;
    public MyList(){
        this.capacity=10;
        this.setList();

    }

    public MyList(Integer capacity) {
        this.capacity = capacity;
        this.setList();
    }

    public Integer getCapacity(){
        return this.capacity;
    }

    public void add(T data){
        if(this.get(0) == null){
            this.list[this.itemSize] = data;
            return;
        }
        this.itemSize++;
        if (this.size() >= this.capacity) {
            this.capacityUpdate();
        }
        this.list[this.itemSize] = data;


    }

    private void capacityUpdate() {
        this.capacity = this.capacity*2;
        this.tempList = (T[]) new Object[this.capacity];
        for (int i=0;i<this.list.length;i++) {
            this.tempList[i] = this.list[i];
        }
        this.list = this.tempList;
    }

    public void setList() {
        this.list = (T[]) new Object[this.capacity];
    }

    public Integer size(){
        return this.itemSize;
    }

    public T get(int index){
        try {
            T i = this.list[index];
            return i;
        }catch (Exception e){
            return null;
        }
    }

    public T remove(int index){
        if(this.get(index)!=null){
        this.tempList = this.list;
        int tempSize=0;
        for (int i=0;i<this.size();i++) {
            if(i!=index){
                this.list[tempSize]=this.tempList[i];
                tempSize++;
            }
        }
        }
        return null;
    }


    public T set(int index,T data){
        if(this.get(index)!=null){
            for (int i=0;i<this.list.length;i++) {
                if(i==index){
                    this.list[i] = data;
                }
            }
        }
        return null;
    }
    @Override
    public String toString(){
        System.out.print("[");
        for (int i=0;i<this.size()+1;i++) {
            if (i == this.size() && this.list[i]!=null) {
                System.out.print(this.list[i]);
            }else if (this.list[i]!=null){
                System.out.print(this.list[i]+",");
            }
        }
        System.out.println("]");
        return "";
    }

    public int indexOf(T data){
        for(int i=0;i<this.size();i++){
            if(this.list[i]==data){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){
        int k = -1;
        for(int i=0;i<this.size();i++){
            if(this.list[i]==data){
                 k = i;
            }
        }
        return k;
    }

    public boolean isEmpty(){
        if(this.get(0) == null){
            return true;
        }
        return false;
    }

    public T toArray(){
        return (T)this.list;
    }

    public void clear(){
        this.setList();
    }

    public MyList<T> sublist(int start,int finish){
        MyList<T> array = new MyList<>(finish);

        for(int i=start;i<finish;i++){
            array.add(this.list[i]);
        }
        return array;
    }

    public boolean contains(T data){
        for (int i=0;i<this.size();i++) {
            if(this.list[i]==data){
                return true;
            }
        }
        return false;
    }
}
