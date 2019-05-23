# [Method creates promiscuous ServerSocket object](http://fb-contrib.sourceforge.net/bugdescriptions.html#MDM_PROMISCUOUS_SERVERSOCKET)

Do not use the `ServerSocket` constructor or `ServerSocketFactory.createServerSocket()` factory methods that
			accept connections on any network interface. By default, an application that listens on a socket will listen for connection attempts
			on any network interface, which can be a security risk. Only the long form of the `ServerSocket` constructor or
			`ServerSocketFactory.createServerSocket()` factory methods take a specific local address to define which network interface
			the socket should bind.