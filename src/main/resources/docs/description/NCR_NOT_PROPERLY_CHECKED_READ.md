# [Return value of read() is not properly checked, array may be partially filled](https://spotbugs.readthedocs.io/en/latest/bugDescriptions.html#NCR_NOT_PROPERLY_CHECKED_READ)

          When using the read() method to fill an array, the method may not always fill the entire array. This can occur when the input stream does not have enough bytes available to completely fill the array, leading to a partial read. This issue can result in unexpected behavior if the partially filled array is assumed to be fully populated.

          It is crucial to verify the return value of the read() method, which indicates the number of bytes actually read, and to ensure that the array is fully filled if necessary. Failing to do so can result in incomplete data processing and potential vulnerabilities.

          To fix this issue, check the return value of read() and handle cases where fewer bytes are read than expected. Consider looping over the read() call or using methods like readFully() to ensure that the array is filled completely.

          See SEI CERT rule [FIO10-J. Ensure the array is filled when using read() to fill an array](https://cmu-sei.github.io/secure-coding-standards/sei-cert-oracle-coding-standard-for-java/rules/input-output-fio/fio10-j/) for more information.