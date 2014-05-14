clf;
n=100000;
X=grand(1,n,'nor',0,1);
Y=grand(1,n,'nor',0,4);

histplot(floor(sqrt(n)),X+Y);
function y=f(x,m,s)
    y=1/(s*sqrt(2*%pi))*exp(-(x-m)^2/(2*s^2))
endfunction

x=linspace(-20,20,2*n);
plot(x,f(x,0,sqrt(1+16)));
show_window;
