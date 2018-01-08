clc; 
clear all;
close all;
% w = warning('query','last');
% id = w.identifier;
% warning('off',id);
n=input('Enter choice ');
switch(n)
    case 1
        cn=zeros(1,200);
        pn=zeros(1,200);
        power=0;
        for i=1:1:200
            sign1= @(t) 1.*exp(-1j*((i)*pi*t));
            cn(i)=integral(sign1,0,1)/2;
            pn(i)=angle(cn(i));
            power=power+abs(cn(i))*abs(cn(i));
        end;
        sign3 = @(t) heaviside(t)-heaviside(t-1);
        a = integral(sign3,0,1)/2
        disp(power);
        disp(2*abs(cn(99))*abs(cn(99))+2*abs(cn(98))*abs(cn(98))+abs(cn(100))*abs(cn(100)));
        figure;
        subplot(2,2,1);
        stem(cn);
        subplot(2,2,2);
        stem(pn);
        t=linspace(0,2,200);
        res=zeros(1,200);
        for i=1:1:200
            if(t(i)<=1)
                res(i)=1;
            else
                res(i)=0;
            end;
        end;
        subplot(2,2,3);
        stem(t,res);
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for k=1:1:200
                g(i)=g(i)+(cn(k))*exp(((k-100)*1j*pi*t(i)));
            end;
        end;
        stem(t,g);
        case 2
        cn=zeros(1,200);
        pn=zeros(1,200);
        power=0;
        for i=1:1:200
            sign1= @(t) 1.*exp(-1j*((i-100)*pi*t));
            sign2=@(t) -1.*exp(-1j*((i-100)*pi*t));
            cn(i)=1*(integral(sign1,0,1)+integral(sign2,1,2))/2;
            pn(i)=angle(cn(i));
            power=power+2*abs(cn(i))*abs(cn(i));
        end;
        disp(power);
        disp(abs(cn(93))*abs(cn(93))/(abs(cn(95))*abs(cn(95))));
        figure;
        subplot(2,2,1);
        stem(cn);
        subplot(2,2,2);
        stem(pn);
        t=linspace(0,2,200);
        res=zeros(1,200);
        for i=1:1:200
            if(t(i)<=1)
                res(i)=1;
            else
                res(i)=-1;
            end;
        end;
        subplot(2,2,3);
        stem(t,res);
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for k=1:1:200
                g(i)=g(i)+(cn(k)).*exp(((k-100)*1j*pi*t(i)));
            end;
        end;
        stem(t,g);
        case 3
        figure
        cn=zeros(1,10);
        for i=1:1:10
            sign1= @(t) 1.*exp(-1j*((i-5)*1*t));
            cn(i)=1*(integral(sign1,-pi/2,pi/2))/(2*pi);
        end;
        g=zeros(1,10);
        t=linspace(-pi/2,3*pi/2,10);
        for i=1:1:10
            for k=1:1:10
                g(i)=g(i)+(cn(k)).*exp(((k-5)*1j*t(i)));
            end;
        end;
        subplot(3,2,1);
        plot(t,g);
        cn=zeros(1,20);
        for i=1:1:20
            sign1= @(t) 1.*exp(-1j*((i-10)*1*t));
            cn(i)=1*(integral(sign1,-pi/2,pi/2))/(2*pi);
        end;
        g=zeros(1,20);
        t=linspace(-pi/2,3*pi/2,20);
        for i=1:1:20
            for k=1:1:20
                g(i)=g(i)+(cn(k)).*exp(((k-10)*1j*t(i)));
            end;
        end;
        subplot(3,2,2);
        plot(t,g);
        cn=zeros(1,30);
        for i=1:1:30
            sign1= @(t) 1.*exp(-1j*((i-15)*1*t));
            cn(i)=1*(integral(sign1,-pi/2,pi/2))/(2*pi);
        end;
        g=zeros(1,30);
        t=linspace(-pi/2,3*pi/2,30);
        for i=1:1:30
            for k=1:1:30
                g(i)=g(i)+(cn(k)).*exp(((k-15)*1j*t(i)));
            end;
        end;
        subplot(3,2,3);
        plot(t,g);
        cn=zeros(1,40);
        t=linspace(-pi/2,3*pi/2,40);
        for i=1:1:40
            sign1= @(t) 1.*exp(-1j*((i-20)*1*t));
            cn(i)=1*(integral(sign1,-pi/2,pi/2))/(2*pi);
        end;
        g=zeros(1,40);
        for i=1:1:40
            for k=1:1:40
                g(i)=g(i)+(cn(k)).*exp(((k-20)*1j*t(i)));
            end;
        end;
        subplot(3,2,4);
        plot(t,g);
        cn=zeros(1,50);
        power=0;
        for i=1:1:50
            sign1= @(t) 1.*exp(-1j*((i-25)*1*t));
            cn(i)=1*(integral(sign1,-pi/2,pi/2))/(2*pi);
            power=power+abs(cn(i))*abs(cn(i));
        end;
        t=linspace(-pi/2,3*pi/2,50);
        g=zeros(1,50);
        for i=1:1:50
            for k=1:1:50
                g(i)=g(i)+(cn(k)).*exp(((k-25)*1j*t(i)));

            end;
        end;
        subplot(3,2,5);
        plot(t,g);
        cn=zeros(1,100);
        for i=1:1:100
            sign1= @(t) 1.*exp(-1j*((i-50)*1*t));
            cn(i)=1*(integral(sign1,-pi/2,pi/2))/(2*pi);
        end;
        t=linspace(-pi/2,3*pi/2,100);
        g=zeros(1,100);
        for i=1:1:100
            for k=1:1:100
                g(i)=g(i)+(cn(k)).*exp(((k-50)*1j*t(i)));
            end;
        end;
        subplot(3,2,6);
        plot(t,g);
        disp('Error: ');
        disp(pi-power);
        disp('Overshoot ');
        disp((pi-power)/(pi)*100);
    case 4
        ch=input('Enter choice ');
        switch(ch)
            case 1
                w=linspace(-199,200,400);
                k=zeros(1,400);
                for i=1:1:400
                    y=@(t) exp(-2*t).*exp(-1j*w(i)*t);
                    k(i)=integral(y,0,50);
                end;
                subplot(2,1,1);
                stem(abs(k));
                subplot(2,1,2);
                stem(angle(k));
                case 2
                w=linspace(-199,200,400);
                k=zeros(1,400);
                for i=1:1:400
                    y=@(t) exp(2*t).*exp(-1j*w(i)*t);
                    k(i)=integral(y,-50,0);
                end;
                subplot(2,1,1);
                stem(abs(k));
                subplot(2,1,2);
                stem(angle(k));
                case 3
                w=linspace(-199,200,400);
                k=zeros(1,400);
                for i=1:1:400
                    y=@(t) 1.*exp(-1j*w(i)*t);
                    k(i)=integral(y,-0.5,0)+integral(y,0,0.5);
                end;
                subplot(3,1,1);
                stem(abs(k));
                subplot(3,1,2);
                stem(angle(k));
                syms x;
                f=rectangularPulse(x);
                ft_f = fourier(f);
                disp(ft_f);
                hand=matlabFunction(ft_f);
                ib=zeros(1,400);
                for i=1:1:400
                    ib(i)=hand(w(i));
                end;
                subplot(3,1,3);
                stem(abs(ib));
                case 4
                w=linspace(-199,200,400);
                k=zeros(1,400);
                for i=1:1:400
                    y1=@(t) (t+1).*exp(-1j*w(i)*t);
                    y2=@(t) (t-1).*exp(-1j*w(i)*t);
                    k(i)=integral(y1,-1,0)+integral(y2,0,1);
                end;
                subplot(3,1,1);
                stem(abs(k));
                subplot(3,1,2);
                stem(angle(k));
                syms x;
                f=triangularPulse(x);
                ft_f = fourier(f);
                disp(ft_f);
                hand=matlabFunction(ft_f);
                ib=zeros(1,400);
                for i=1:1:400
                    ib(i)=hand(w(i));
                end;
                subplot(3,1,3);
                stem((ib));
                case 5
                w=linspace(-199,200,400);
                k=zeros(1,400);
                for i=1:1:400
                    y=@(t) cos(20*t).*exp(-1j*w(i)*t);
                    k(i)=integral(y,-30,30);
                end;
                subplot(3,1,1);
                stem(abs(k));
                subplot(3,1,2);
                stem(angle(k));
                syms x;
                f=cos(20*x);
                ft_f = fourier(f);
                disp(ft_f);
                hand=matlabFunction(ft_f);
                ib=zeros(1,400);
                for i=1:1:400
                    ib(i)=hand(w(i));
                    if(ib(i)==Inf)
                        ib(i)=30;
                    end;
                end;
                subplot(3,1,3);
                stem(abs(ib));
        end;
end;