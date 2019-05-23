# [Method calls InetAddress.getLocalHost()](http://fb-contrib.sourceforge.net/bugdescriptions.html#MDM_INETADDRESS_GETLOCALHOST)

Do not call `InetAddress.getLocalHost()` on multihomed servers. On a multihomed server,
			`InetAddress.getLocalHost()` simply returns the IP address associated with the server's internal hostname.
			This could be any of the network interfaces, which could expose the machine to security risks. Server applications
			that need to listen on sockets should add configurable properties to define which network interfaces the server should bind.