# [OneToMany join specifies 1+n EAGER join](http://fb-contrib.sourceforge.net/bugdescriptions.html#JPAI_INEFFICIENT_EAGER_FETCH)

This JPA entity specifies a @OneToMany join with a fetch type of EAGER. By default EAGER joins perform
    	select operations on each element returned from the original query in sequence, thus producing 1 + n queries.
    	If you are going to use EAGER joins, it is wise to specify a Join type by using @Fetch annotations in
    	Hibernate or @JoinFetch/@BatchFetch annotations (or hints) in EclipseLink, for example. Even so, these
    	annotations may only apply in limited cases, such as in the use of find.