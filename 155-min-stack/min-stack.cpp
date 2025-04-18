class MinStack {
public:
    vector<pair<int, int>> st;
    MinStack() {
        
    }
    
    void push(int val) {
        if(st.empty()){
            //means , i am inserting 1st element
            pair<int, int> p;
            p.first = val;
            p.second = val;
            st.push_back(p);
        }
        else{
            pair<int, int> p;
            p.first = val;
            int puranaMin = st.back().second;
            p.second = min(puranaMin, val);
            st.push_back(p);
        }
    }
    
    void pop() {
        st.pop_back();
    }
    
    int top() {
        pair<int, int> rightMostpair = st.back();
        return rightMostpair.first;
    }
    
    int getMin() {
        pair<int, int> rightMostpair = st.back();
        return rightMostpair.second;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */