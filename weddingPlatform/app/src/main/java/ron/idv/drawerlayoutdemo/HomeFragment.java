package ron.idv.drawerlayoutdemo;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private List<Member> memberList;
    private ViewPager vpMember;
    LinearLayout mLinearLayout;
    MyPageIndicator mIndicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.pagesContainer);

        List<Member> memberList = getMemberList();
        MemberAdapter memberAdapter = new MemberAdapter(getActivity().getSupportFragmentManager(), memberList);
        vpMember = (ViewPager) view.findViewById(R.id.vpMember);
        vpMember.setAdapter(memberAdapter);



        mIndicator = new MyPageIndicator(getContext(), mLinearLayout, vpMember, R.drawable.indicator_circle);
        mIndicator.setPageCount(memberList.size());
        mIndicator.show();

        return view;
    }

    private List<Member> getMemberList() {
        memberList = new ArrayList<>();
        memberList.add(new Member(23, R.drawable.image1, "John"));
        memberList.add(new Member(75, R.drawable.image2, "Jack"));
        memberList.add(new Member(65, R.drawable.image3, "Mark"));
        memberList.add(new Member(12, R.drawable.image4, "Ben"));
        memberList.add(new Member(92, R.drawable.image5, "James"));
        return memberList;
    }



    private class MemberAdapter extends FragmentStatePagerAdapter {
        List<Member> memberList;

        private MemberAdapter(FragmentManager fm, List<Member> memberList) {
            super(fm);
            this.memberList = memberList;
        }

        @Override
        public int getCount() {
            return memberList.size();
        }

        @Override
        public Fragment getItem(int position) {
            return MemberFragment.newInstance(memberList.get(position));
        }
    }

}
