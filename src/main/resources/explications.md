# UserDetailsService
it is the interface responsable of finding the user in the db 
it had one important method should be implemanted : 
    public UserDetails findUserByUsername(String username)
and the entity should implement UserDetails interface and that to make spring understand the entity