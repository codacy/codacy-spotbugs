# [Method stores return result in local before immediately returning it](http://fb-contrib.sourceforge.net/bugdescriptions.html#USBR_UNNECESSARY_STORE_BEFORE_RETURN)

This method stores the return result in a local variable, and then immediately
			returns the local variable. It would be simpler just to return the value that is
			assigned to the local variable, directly.

				Instead of the following:   

    public float average(int[] arr) {
        float sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        float ave = sum / arr.length;
        return ave;
    }

				Simply change the method to return the result of the division:   

    public float average(int[] arr) {
        float sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length; //Change
    }